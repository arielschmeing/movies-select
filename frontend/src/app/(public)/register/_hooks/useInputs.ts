import { Errors, Register } from "@/src/types";
import { ChangeEvent } from "react";

interface RegisterInputsProps {
  setValue: (key: keyof Register, value: string) => void;
  errors: Errors<Register>;
}

export const useRegisterInputs = ({
  setValue,
  errors,
}: RegisterInputsProps) => {
  const inputsProps = {
    name: {
      name: "Name",
      error: errors.messages.name,
      type: "text",
      placeholder: "eg. John Steven",
      onChange: (e: ChangeEvent<HTMLInputElement>) =>
        setValue("name", e.target.value),
    },
    email: {
      name: "Email",
      error: errors.messages.email,
      type: "email",
      placeholder: "eg. john.steven@email.com",
      onChange: (e: ChangeEvent<HTMLInputElement>) =>
        setValue("email", e.target.value),
    },
    password: {
      name: "Password",
      error: errors.messages.password,
      type: "password",
      placeholder: "Enter your password",
      onChange: (e: ChangeEvent<HTMLInputElement>) =>
        setValue("password", e.target.value),
    },
  } as const;

  return {
    inputsProps,
  };
};
