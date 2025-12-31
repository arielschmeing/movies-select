"use client";

import { Button } from "@/src/components/ui/button";
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/src/components/ui/card";
import { Input } from "@/src/components/ui/input";
import { FilmIcon } from "lucide-react";
import { useLogin } from "./_hooks/useLogin";
import ErrorMessage from "@/src/components/ui/errorMessage";

export default function Page() {
  const { btnsProps, inputsProps } = useLogin();

  return (
    <section className="w-full h-full flex items-center justify-center relative">
      <Card className="max-w-md w-full bg-neutral-950 shadow-lg shadow-neutral-950 text-neutral-100 border-none text-center">
        <CardHeader>
          <FilmIcon className="m-auto mb-4 w-16 h-auto" />
          <CardTitle className="text-2xl">Welcome to Movies Select</CardTitle>
          <CardDescription>
            Dont`t have an account yet?
            <Button
              variant="link"
              className="text-neutral-100 px-2 py-0 cursor-pointer"
              {...btnsProps.register}
            >
              Register
            </Button>
          </CardDescription>
        </CardHeader>
        <CardContent className="flex flex-col gap-6">
          {Object.entries(inputsProps).map(([key, props]) => (
            <div className="relative" key={key}>
              <ErrorMessage
                message={props.error}
                className="absolute -top-5.5 text-sm ml-2"
              />
              <props.Icon className="absolute top-1.5 left-3 w-4" />
              <Input className="pl-10 input-primary" {...props.input} />
            </div>
          ))}
        </CardContent>
        <CardFooter>
          <Button className="w-full btn-primary" {...btnsProps.login}>
            Login
          </Button>
        </CardFooter>
      </Card>
      <div
        className="absolute inset-0 -z-1"
        style={{
          background:
            "radial-gradient(ellipse 80% 60% at 50% 0%, rgba(99, 102, 241, 0.25), transparent 70%), #000000",
        }}
      ></div>
    </section>
  );
}
