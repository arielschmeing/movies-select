"use client";

import { Button } from "@/src/components/ui/button";
import { PATH_ROUTES } from "@/src/constants/app.constants";
import { useRouter } from "next/navigation";
import { deleteCookie } from "./_hooks/action";

export default function Page() {
  const route = useRouter();
  const handler = async () => {
    await deleteCookie();
    route.push(PATH_ROUTES.LOGIN);
  };

  return (
    <section className="flex flex-col gap-4 items-center justify-center w-full h-full">
      <h1 className="text-white text-2xl">DASHBOARD PRIVADO</h1>

      <Button className="btn-primary" onClick={() => handler()}>
        LOG OUT
      </Button>
    </section>
  );
}
