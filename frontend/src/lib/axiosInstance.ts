import axios, { HttpStatusCode } from "axios";

const TIMEOUT = 10000;

const axiosInstances = axios.create({
  baseURL: process.env.NEXT_PUBLIC_API_URL,
  withCredentials: true,
  timeout: TIMEOUT,
});

axiosInstances.interceptors.request.use(
  (config) => config,
  (error) => Promise.reject(error)
);

axiosInstances.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error.response?.status === HttpStatusCode.Unauthorized) {
      console.warn("Unauthorized. Redirecting to login...");
    }
    return Promise.reject(error);
  }
);

export default axiosInstances;
