import { create } from "zustand";
import { Payload } from "../types";
import { cookies } from "next/headers";
import { jwtDecode } from "jwt-decode";
import { COOKIES } from "../constants/app.constants";

interface AuthStorage {
  getPayload: () => Promise<Payload>;
}

export const useAuthStorage = create<AuthStorage>()(() => ({
  getPayload: async () => {
    const cookieStorage = await cookies();
    const token = cookieStorage.get(COOKIES.TOKEN);

    if (!token) throw Error("Cookie does not exist.");

    return jwtDecode<Payload>(token.value);
  },
}));
