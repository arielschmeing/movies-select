"use server";

import { cookies } from "next/headers";
import { COOKIES } from "../constants/app.constants";

const getTokenCookie = async () => {
  const cookiesStorage = await cookies();

  if (!cookiesStorage.has(COOKIES.TOKEN))
    throw new Error("User token does not exist.");

  return cookiesStorage;
};

export const getToken = async (): Promise<string> => {
  return (await getTokenCookie()).get(COOKIES.TOKEN)!.value;
};

export const deleteToken = async () => {
  const cookiesStorage = await getTokenCookie();
  cookiesStorage.delete(COOKIES.TOKEN);
};
