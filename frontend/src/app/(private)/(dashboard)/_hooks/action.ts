"use server"

import { COOKIES } from "@/src/constants/app.constants"
import { cookies } from "next/headers"

export const deleteCookie = async () => {
  const cookieStore = await cookies()
  cookieStore.delete(COOKIES.TOKEN)
}