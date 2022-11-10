import {createStore} from "vuex";
import createPersistedState from "vuex-persistedstate";

import {userStore} from "@/store/modules/userStore.js";

export default createStore({
    modules: { userStore },
    state: {},
    getters: {},
    mutations: {},
    actions: {},
    plugins: [
      createPersistedState({
        paths: ["userStore"],
        // 브라우저 종료시 제거하기 위해 localStorage가 아닌 sessionStorage로 변경. (default: localStorage)
        storage: sessionStorage,
      })
    ]
  });