import { QUERY_KEYS } from "@/src/constants/app.constants";
import { useMutation, useQueryClient } from "@tanstack/react-query";
import { useToast } from "../useToast";
import { useUserStorage } from "@/src/stores/user.store";
import { authService } from "@/src/services";

export const useQueryAuth = () => {
  const queryClient = useQueryClient();
  const { setUser } = useUserStorage();
  const { error, success } = useToast();
  const { mutateAsync: loginFn } = useMutation({
    mutationFn: authService.post,
    onSuccess: (data) => {
      setUser(data);
      queryClient.setQueryData(QUERY_KEYS.USER_PROFILE, data);
      success("User logged.");
    },
    onError: () => error("Login invalid, try again."),
  });

  return {
    loginFn,
  };
};
