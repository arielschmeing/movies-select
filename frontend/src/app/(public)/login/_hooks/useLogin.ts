import { ROUTER_PATHS } from "@/src/constants/app.constants";
import { Login, loginValidation } from "@/src/types";
import { useRouter } from "next/navigation";
import { useLoginInputs } from "./useInputs";
import { useForm, useQueryAuth, useToast } from "@/src/hooks";

export const useLogin = () => {
  const { error } = useToast();
  const { data, errors, setValue, submit } = useForm<Login>({
    validations: loginValidation,
  });
  const { loginFn } = useQueryAuth();
  const { inputsProps } = useLoginInputs({ errors, setValue, data });
  const router = useRouter();
  const btnsProps = {
    register: {
      onClick: () => router.push(ROUTER_PATHS.REGISTER),
    },
    login: {
      onClick: async () => {
        if (!submit()) return error("Invalid user login.");

        await loginFn(data);
        router.push(ROUTER_PATHS.ROOT);
      },
    },
  } as const;

  return {
    btnsProps,
    inputsProps,
  };
};
