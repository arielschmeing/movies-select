"use client";

import PartyCard from "@/src/components/layout/partyCard";
import { useUserStorage } from "@/src/stores/user.store";
import { PartyPopperIcon } from "lucide-react";

export default function Page() {
  const { user } = useUserStorage();

  return (
    <section className="w-full h-full flex flex-col p-6">
      <header className="border-b border-neutral-800 pb-7 mb-7 flex items-center text-neutral-200">
        <PartyPopperIcon className="size-10 mr-4" />
        <h1 className="text-3xl font-semibold ">Your Parties</h1>
      </header>

      <div>
        {user?.parties?.map((party) => (
          <PartyCard key={party.id} party={party} />
        ))}
      </div>
    </section>
  );
}
