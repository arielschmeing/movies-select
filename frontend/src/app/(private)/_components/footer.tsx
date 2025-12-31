import {
  Avatar,
  AvatarFallback,
  AvatarImage,
} from "@/src/components/ui/avatar";
import { User } from "@/src/types";

interface MenuFooterProps {
  user: User | null;
}

export default function MenuFooter({ user }: MenuFooterProps) {
  if (!user) return null;

  return (
    <footer>
      <Avatar>
        <AvatarImage src="/images/default-avatar.jpg" alt={`@${user.email}`} />
        <AvatarFallback />
      </Avatar>
    </footer>
  );
}
