import { API_PATHS } from "../constants/api.constants";
import axiosInstances from "../lib/axiosInstance";
import { Login, User } from "../types"

export const authService = {
  post: async (request: Login) => {
    const { data } = await axiosInstances.post<User>(API_PATHS.AUTH, request);
    return data;
  }
}