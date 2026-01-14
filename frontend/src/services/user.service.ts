import { jwtDecode } from "jwt-decode";
import { getToken } from "../lib/actions";
import { Payload, Register, User } from "../types";
import axiosInstances from "../lib/axiosInstance";
import { API_PATHS } from "../constants/api.constants";

export const userService = {
  get: async ({ id }: { id: string }): Promise<User> => {
    const { data } = await axiosInstances.get<User>(API_PATHS.USERS.ID(id));
    return data;
  },
  getProfile: async (): Promise<User> => {
    const token = await getToken();
    const { id } = jwtDecode<Payload>(token);
    return userService.get({ id });
  },
  post: async (request: Register): Promise<User> => {
    const { data } = await axiosInstances.post<User>(
      API_PATHS.USERS.ROOT,
      request
    );
    return data;
  },
};
