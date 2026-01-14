import {
  Avatar,
  AvatarFallback,
  AvatarImage,
} from "@/src/components/ui/avatar";
import { Button } from "@/src/components/ui/button";
import { User } from "@/src/types";
import { LogOutIcon } from "lucide-react";
import { useMenuFooter } from "../_hooks/useFooter";

interface MenuFooterProps {
  user: User | null;
}

export default function MenuFooter({ user }: MenuFooterProps) {
  const { logoutProps } = useMenuFooter();

  if (!user) return null;

  return (
    <footer className="flex w-full justify-between items-center mb-4 pt-7 border-t border-neutral-700">
      <section className="flex items-center gap-2">
        <Avatar>
          <AvatarImage
            sizes=""
            src="/images/default-avatar.jpg"
            alt={`@${user.email}`}
          />
          <AvatarFallback>AV</AvatarFallback>
        </Avatar>
        <aside>
          <p className="text-sm font-bold">{user.name}</p>
          <p className="text-[12px]">{user.email}</p>
        </aside>
      </section>
      <Button {...logoutProps}>
        <LogOutIcon />
      </Button>
    </footer>
  );
}
