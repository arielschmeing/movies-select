import { ROUTER_PATHS } from "@/src/constants/app.constants";
import { useToast } from "@/src/hooks";
import { deleteToken } from "@/src/lib/actions";
import { useRouter } from "next/navigation";

export const useMenuFooter = () => {
  const { success } = useToast();
  const router = useRouter();
  const logoutProps = {
    className:
      "text-neutral-200 hover:text-neutral-100 hover:bg-red-400 cursor-pointer",
    variant: "link",
    size: "icon",
    onClick: async () => {
      await deleteToken();
      router.push(ROUTER_PATHS.LOGIN);
      success("User logout.");
    },
  } as const;

  return {
    logoutProps,
  };
};
