import { useQueryProfile } from "@/src/hooks";
import { useUserStorage } from "@/src/stores/user.store";
import { useEffect } from "react";

export const useProfile = () => {
  const { user, isSuccess } = useQueryProfile();
  const { setUser } = useUserStorage();

  useEffect(() => {
    if (!isSuccess) return;
    setUser(user!);
  }, [user, isSuccess, setUser]);
};
