import { Button } from "@/src/components/ui/button";
import { useRegister } from "../_hooks/useRegister";
import { Input } from "@/src/components/ui/input";
import { Label } from "@/src/components/ui/label";
import ErrorMessage from "@/src/components/ui/errorMessage";

export default function RegisterForm() {
  const { btnsProps, inputsProps } = useRegister();

  return (
    <section className="text-neutral-200 max-w-xl flex flex-col gap-12">
      <article className="text-center">
        <h2 className="text-2xl mb-2">Register Account</h2>
        <p>Enter your personal data to create yout account.</p>
      </article>

      <article className="flex flex-col gap-2">
        {Object.entries(inputsProps).map(([key, input]) => (
          <div key={key}>
            <Label className="font-semibold" htmlFor={key}>
              {input.name}
              <ErrorMessage message={input.error} />
            </Label>
            <Input
              className="input-primary my-2"
              id={key}
              placeholder={input.placeholder}
              onChange={input.onChange}
              type={input.type}
            />
          </div>
        ))}
      </article>

      <article className="flex flex-col gap-2">
        <Button
          className="btn-primary font-semibold w-full"
          {...btnsProps.register}
        >
          Register
        </Button>
        <p className="text-sm text-center text-neutral-400">
          Already have a account?{" "}
          <Button
            className="text-neutral-200 cursor-pointer"
            variant="link"
            {...btnsProps.login}
          >
            Login
          </Button>
        </p>
      </article>
    </section>
  );
}
