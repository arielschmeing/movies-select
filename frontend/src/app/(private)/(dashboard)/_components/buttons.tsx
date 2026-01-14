import CreatePartyDialog from "@/src/components/layout/createPartyDialog";
import { Button } from "@/src/components/ui/button";
import { PopcornIcon } from "lucide-react";

export default function DashboardButtons() {
  return (
    <div className="flex gap-4">
      <CreatePartyDialog />
      <Button className="cursor-pointer bg-neutral-800 hover:bg-neutral-700 w-1/2">
        <PopcornIcon />
        Entry in party
      </Button>
    </div>
  );
}
