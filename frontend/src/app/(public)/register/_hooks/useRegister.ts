import { useForm } from "@/src/hooks/useForm";
import { Register, registerValidations } from "@/src/types";
import { useRegisterInputs } from "./useInputs";
import { useRouter } from "next/navigation";
import { ROUTER_PATHS } from "@/src/constants/app.constants";
import { useQueryRegister, useToast } from "@/src/hooks";

export const useRegister = () => {
  const router = useRouter();
  const { error } = useToast();
  const { data, errors, setValue, submit } = useForm<Register>({
    validations: registerValidations,
  });
  const { registerFn } = useQueryRegister();
  const { inputsProps } = useRegisterInputs({ setValue, errors });
  const btnsProps = {
    register: {
      onClick: async () => {
        if (!submit) return error("Invalid data to register user.");

        await registerFn(data);
        router.push(ROUTER_PATHS.ROOT);
      },
    },
    login: {
      onClick: () => router.push(ROUTER_PATHS.LOGIN),
    },
  };

  return {
    btnsProps,
    inputsProps,
  };
};
