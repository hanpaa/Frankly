import axios from "axios";

// axios 객체 생성
const http = axios.create({
    baseURL: "http://localhost:8081",
    //baseURL: 'http://teamfrankly.kr',
    headers: {
        "Content-type": "application/json"
    },
});


export { http };

