import { QUERY_KEYS } from "@/src/constants/app.constants";
import { userService } from "@/src/services";
import { useQuery } from "@tanstack/react-query";

export const useQueryProfile = () => {
  const { data, isSuccess } = useQuery({
    queryKey: QUERY_KEYS.USER_PROFILE,
    queryFn: userService.getProfile,
  });

  return {
    user: data,
    isSuccess,
  };
};