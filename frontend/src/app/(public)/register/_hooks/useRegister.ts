import { useForm } from "@/src/hooks/useForm";
import { Register, registerValidations, User } from "@/src/types";
import { useRegisterInputs } from "./useRegisterInputs";
import { useRouter } from "next/navigation";
import { PATH_ROUTES } from "@/src/constants/app.constants";
import { useToast } from "@/src/hooks/useToast";
import { useMutation } from "@tanstack/react-query";
import axiosInstances from "@/src/lib/axiosInstance";
import { API_PATHS } from "@/src/constants/api.constants";
import { useUserStorage } from "@/src/stores/user.store";

export const useRegister = () => {
  const router = useRouter();
  const { setUser } = useUserStorage();
  const { error, success } = useToast();
  const { data, errors, setValue, submit } = useForm<Register>({
    validations: registerValidations,
  });
  const { mutateAsync: registerUserFn } = useMutation({
    mutationFn: async (data: Register) => {
      const response = await axiosInstances.post<User>(API_PATHS.USERS, data);
      return response.data;
    },
    onSuccess: (data) => {
      setUser(data);
      router.push(PATH_ROUTES.ROOT);
      success("User logged.");
    },
    onError: () => error("User email does already exist or invalid."),
  });
  const { inputsProps } = useRegisterInputs({ setValue, errors });
  const btnsProps = {
    register: {
      onClick: async () => {
        if (!submit) return error("Invalid data to register user.");

        await registerUserFn(data);
      },
    },
    login: {
      onClick: () => router.push(PATH_ROUTES.LOGIN),
    },
  };

  return {
    btnsProps,
    inputsProps,
  };
};
