"use client"

import { Button } from "@/src/components/ui/button";
import { useParty } from "./_hooks/useParty";

export default function Page() {
  const { party, btnProps } = useParty()

  // TODO: VALIDAR SE USUARIO ESTA NA PARTY ANTES DE VER ELA
  return (
    <section>
      <h1 className="text-3xl text-neutral-200">PARTY: {party?.name}</h1>
      <Button {...btnProps} >Pedidos</Button>
    </section>
  );
}
