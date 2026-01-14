import { CircleFadingPlusIcon } from "lucide-react";
import { Button } from "../ui/button";
import {
  Dialog,
  DialogClose,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "../ui/dialog";
import { Label } from "../ui/label";
import { Input } from "../ui/input";
import { useCreateParty } from "./_hooks/useCreateParty";

export default function CreatePartyDialog() {
  const {} = useCreateParty();

  return (
    <Dialog>
      <DialogTrigger asChild>
        <Button className="btn-primary w-1/2">
          <CircleFadingPlusIcon />
          Create party
        </Button>
      </DialogTrigger>
      <DialogContent className="bg-neutral-900 border-neutral-800 text-neutral-200">
        <DialogHeader>
          <DialogTitle className="text-neutral-200 text-3xl">
            Customize Your Party
          </DialogTitle>
          <DialogDescription className="text-neutral-500 text-md border-b mb-4 pb-6 border-neutral-700">
            Give your new party a personality with name.
          </DialogDescription>
          <div>
            <Label className="font-semibold text-neutral-500" htmlFor="name">
              Name
            </Label>
            <Input
              className="border-neutral-700 mt-3 bg-neutral-800"
              id="name"
            />
          </div>
        </DialogHeader>
        <DialogFooter className="mt-4">
          <DialogClose asChild>
            <Button className="bg-neutral-700 border-none cursor-pointer hover:bg-neutral-600">
              Cancel
            </Button>
          </DialogClose>
          <Button className="btn-primary">Create</Button>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  );
}
