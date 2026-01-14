"use client";

import {
  NavigationMenu,
  NavigationMenuItem,
  NavigationMenuLink,
  NavigationMenuList,
} from "@/src/components/ui/navigationMenu";
import { useMenu } from "../_hooks/useMenu";
import Link from "next/link";
import MenuHeader from "./header";
import MenuFooter from "./footer";

export default function Menu() {
  const { itemsProps, menuClasses, user } = useMenu();

  return (
    <NavigationMenu className={menuClasses.wrapper}>
      <NavigationMenuList className="flex flex-col w-52">
        <MenuHeader />
        {Object.entries(itemsProps).map(([key, item]) => (
          <NavigationMenuItem key={key} className="w-full">
            <NavigationMenuLink asChild className={menuClasses.link}>
              <Link href={item.href}>
                <div className="flex">
                  <item.Icon className="text-neutral-200 mr-4 size-5" />
                  <p>{item.title}</p>
                </div>
              </Link>
            </NavigationMenuLink>
          </NavigationMenuItem>
        ))}
      </NavigationMenuList>
      <MenuFooter user={user} />
    </NavigationMenu>
  );
}
