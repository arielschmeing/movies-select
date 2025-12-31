export const loginValidation = {
  email: (value: string) => {
    if (!value) return "Invalid Email";
  },
  password: (value: string) => {
    if (!value) return "Invalid Password";
  },
}

export const registerValidations = {
  name: (value: string) => {
    if (!value) return "Invalid Name";
  },
  ...loginValidation
};

export interface Register extends Login {
  name: string;
}

export interface Login {
  email: string;
  password: string;
}

export interface Errors<T> {
  messages: {
    [K in keyof T]?: string;
  };
}