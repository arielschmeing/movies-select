import { API_PATHS } from "../constants/api.constants";
import axiosInstances from "../lib/axiosInstance";
import { Order, Party } from "../types";

export const partyService = {
  get: async ({ id }: { id: string }): Promise<Party> => {
    const { data } = await axiosInstances.get<Party>(API_PATHS.PARTIES.ID(id));
    return data;
  },
  getOrders: async ({ id }: { id: string }): Promise<Order[]> => {
    const { data } = await axiosInstances.get<Order[]>(API_PATHS.PARTIES.ORDERS(id));
    return data;
  }
};
