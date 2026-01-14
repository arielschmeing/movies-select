"use client";

import DashboardButtons from "./_components/buttons";
import { FilmIcon } from "lucide-react";

export default function Page() {
  return (
    <section className="w-full h-full">
      <div className="flex items-center justify-center w-full h-full gap-20">
        <div className="relative">
          <aside
            className="
            flex items-center absolute bg-neutral-950
            -top-14 shadow py-1 px-4 rounded-md 
            shadow-indigo-800 text-neutral-200 gap-2"
          >
            <FilmIcon className="size-5" />
            <p>What movies are showing today?</p>
          </aside>
          <p className="text-neutral-200 text-5xl font-semibold max-w-xl leading-16">
            Welcome, create your own
            <span className="text-indigo-500"> party</span> or participate.
          </p>
        </div>
        <div className="max-w-sm flex flex-col">
          <p className="text-neutral-200 mb-4 leading-7">
            Create yout party to share movies and series with other users. Your
            journey begins here.
          </p>
          <DashboardButtons />
        </div>
      </div>
    </section>
  );
}
