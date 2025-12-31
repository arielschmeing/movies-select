import { Errors, Login } from "@/src/types";
import { Lock, Mail } from "lucide-react";
import { ChangeEvent } from "react";

interface LoginInputs {
  errors: Errors<Login>;
  setValue: (key: keyof Login, value: string) => void;
  data: Login;
}

export const useLoginInputs = ({ errors, setValue, data }: LoginInputs) => {
  const inputsProps = {
    email: {
      Icon: Mail,
      error: errors.messages.email,
      input: {
        type: "email",
        defaultValue: data.email,
        placeholder: "Email address",
        onChange: (e: ChangeEvent<HTMLInputElement>) => {
          setValue("email", e.target.value);
        },
      },
    },
    password: {
      Icon: Lock,
      error: errors.messages.password,
      input: {
        type: "password",
        defaultValue: data.password,
        placeholder: "Password",
        onChange: (e: ChangeEvent<HTMLInputElement>) => {
          setValue("password", e.target.value);
        },
      },
    },
  } as const;

  return {
    inputsProps,
  };
};
