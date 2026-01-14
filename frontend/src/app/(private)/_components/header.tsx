import { FilmIcon } from "lucide-react";

export default function MenuHeader() {
  return (
    <header className="w-full flex items-center pb-7 pt-4 mb-7 border-b border-y-neutral-800">
      <FilmIcon className="size-8 mr-2" />
      <h2 className="text-xl font-bold pb-1">Movies Select</h2>
    </header>
  );
}
