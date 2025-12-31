import { create } from "zustand";
import { User } from "../types";

interface UserStorage {
  user: User | null
  setUser: (user: User | null) => void
}

export const useUserStorage = create<UserStorage>()((set) => ({
  user: null,
  setUser: (user: User | null) => {
    set({ user })
  }
}))