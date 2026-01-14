import { ROUTER_PATHS } from "@/src/constants/app.constants";
import { useUserStorage } from "@/src/stores/user.store";
import { HomeIcon, PartyPopperIcon, SearchIcon } from "lucide-react";

export const useMenu = () => {
  const { user } = useUserStorage();

  const menuClasses = {
    wrapper: `flex flex-col items-start 
      justify-between
      text-neutral-200 border-r 
      border-neutral-800 p-4`,
    link: `w-full hover:bg-neutral-700 
      data-[active=true]:bg-neutral-600 
      focus:bg-neutral-600 
      hover:text-neutral-200  
      data-[active=true]:text-neutral-200 
      **:text-neutral-200`,
  } as const;

  const itemsProps = {
    home: {
      Icon: HomeIcon,
      title: "Home",
      href: ROUTER_PATHS.ROOT,
    },
    search: {
      Icon: SearchIcon,
      title: "Search",
      href: ROUTER_PATHS.SEARCH,
    },
    parties: {
      Icon: PartyPopperIcon,
      title: "Parties",
      href: ROUTER_PATHS.PARTIES.ROOT,
    },
  } as const;

  return {
    itemsProps,
    menuClasses,
    user,
  };
};
