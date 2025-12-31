import { PATH_ROUTES } from "@/src/constants/app.constants";
import { useUserStorage } from "@/src/stores/user.store";
import { useQuery } from "@tanstack/react-query";
import { HomeIcon, PartyPopperIcon, SearchIcon } from "lucide-react";

export const useMenu = () => {
  const { user } = useUserStorage();
  const {} = useQuery({
    queryKey: ["", ]
  })

  const menuClasses = {
    wrapper: `flex items-start 
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
      href: PATH_ROUTES.ROOT,
    },
    search: {
      Icon: SearchIcon,
      title: "Search",
      href: PATH_ROUTES.SEARCH,
    },
    parties: {
      Icon: PartyPopperIcon,
      title: "Parties",
      href: PATH_ROUTES.PARTIES,
    },
  } as const;

  return {
    itemsProps,
    menuClasses,
    user,
  };
};
