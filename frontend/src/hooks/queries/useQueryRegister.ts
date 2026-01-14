import { useMutation, useQueryClient } from "@tanstack/react-query";
import { useToast } from "../useToast";
import { useUserStorage } from "@/src/stores/user.store";
import { QUERY_KEYS } from "@/src/constants/app.constants";
import { userService } from "@/src/services";

export const useQueryRegister = () => {
  const queryClient = useQueryClient();
  const { setUser } = useUserStorage();
  const { success, error } = useToast();
  const { mutateAsync: registerFn } = useMutation({
    mutationFn: userService.post,
    onSuccess: (data) => {
      setUser(data);
      queryClient.setQueryData(QUERY_KEYS.USER_PROFILE, data);
      success("User logged.");
    },
    onError: () => error("User email does already exist or invalid."),
  });

  return {
    registerFn,
  };
};
