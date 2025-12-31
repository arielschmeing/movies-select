import { API_PATHS } from "@/src/constants/api.constants";
import { PATH_ROUTES } from "@/src/constants/app.constants";
import { useForm } from "@/src/hooks/useForm";
import axiosInstances from "@/src/lib/axiosInstance";
import { useUserStorage } from "@/src/stores/user.store";
import { Login, User, loginValidation } from "@/src/types";
import { useMutation } from "@tanstack/react-query";
import { useRouter } from "next/navigation";
import { useLoginInputs } from "./useLoginInputs";
import { useToast } from "@/src/hooks/useToast";

export const useLogin = () => {
  const { error, success } = useToast();
  const { data, errors, setValue, submit } = useForm<Login>({
    validations: loginValidation,
  });
  const { setUser } = useUserStorage();
  const { mutateAsync: loginUserFn } = useMutation({
    mutationFn: async (payload: Login) => {
      const { data } = await axiosInstances.post<User>(API_PATHS.AUTH, payload);
      return data;
    },
    onSuccess: (data) => {
      setUser(data);
      router.push(PATH_ROUTES.ROOT);
      success("User logged.");
    },
    onError: () => error("Login invalid, try again."),
  });

  const { inputsProps } = useLoginInputs({ errors, setValue, data });
  const router = useRouter();
  const btnsProps = {
    register: {
      onClick: () => router.push(PATH_ROUTES.REGISTER),
    },
    login: {
      onClick: async () => {
        if (!submit()) return error("Invalid user login.");

        await loginUserFn(data);
      },
    },
  } as const;

  return {
    btnsProps,
    inputsProps,
  };
};
