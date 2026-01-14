import { Party } from "@/src/types";
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "../ui/card";
import { Avatar, AvatarFallback, AvatarImage } from "../ui/avatar";
import { formatDate } from "@/src/lib/utils";
import { Button } from "../ui/button";
import { useRouter } from "next/navigation";
import { ROUTER_PATHS } from "@/src/constants/app.constants";

interface PartyCardProps {
  party: Party;
}

export default function PartyCard({ party }: PartyCardProps) {
  const router = useRouter();

  return (
    <Card className="bg-neutral-800 border-none max-w-3xs p-4">
      <CardHeader className="flex items-start justify-between p-0">
        <h4 className="text-neutral-100 text-3xl font-semibold bg-indigo-600 size-14 grid place-items-center rounded-lg">
          {party.name[0].toUpperCase()}
        </h4>
        <div className="flex">
          {Array.from({ length: 3 }).map((_, index) => (
            <Avatar key={index} className="-ml-3 border-2 border-neutral-800">
              <AvatarImage src="./images/default-avatar.jpg" />
              <AvatarFallback>AV</AvatarFallback>
            </Avatar>
          ))}
        </div>
      </CardHeader>
      <CardContent className="text-neutral-200 flex flex-col gap-2 p-0">
        <CardTitle>{party.name}</CardTitle>
        <CardDescription>
          {formatDate(party.createdAt.toString())}
        </CardDescription>
      </CardContent>
      <CardFooter className="p-0">
        <Button
          onClick={() => router.push(ROUTER_PATHS.PARTIES.ID.ROOT(party.id))}
          className="btn-primary w-full"
        >
          See more
        </Button>
      </CardFooter>
    </Card>
  );
}
