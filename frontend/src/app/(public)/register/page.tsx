"use client";

import { FilmIcon } from "lucide-react";
import RegisterForm from "./_components/form";

export default function Page() {
  return (
    <section className="flex">
      <div className="min-h-screen w-1/2 relative bg-black">
        <div
          className="absolute inset-0 z-0"
          style={{
            background:
              "radial-gradient(ellipse 80% 60% at 50% 0%, rgba(99, 102, 241, 0.25), transparent 70%), #000000",
          }}
        >
          <article className="text-neutral-200 gap-4 w-full flex flex-col items-center justify-center h-full">
            <div className="flex items-center gap-4">
              <FilmIcon className="w-10 h-auto" />
              <h1 className="text-3xl">Movies Select</h1>
            </div>
            <h2 className="text-4xl font-semibold text-shadow-neutral-500 text-shadow-md">
              Get Started
            </h2>
            <p className="max-w-2xs text-center">
              Create account for share your movie party, movies and series
            </p>
          </article>
        </div>
      </div>
      <div className="w-1/2 bg-neutral-950 flex justify-center items-center">
        <RegisterForm />
      </div>
    </section>
  );
}
