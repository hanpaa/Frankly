<template>
  <div class="wrap">
    <!--헤더-->
    <header class="header header--back">
      <a class="icon-button-56 header__back-button" @click="$router.go(-1)">
        <img src="@/assets/icon/Arrow_left48.svg" alt="뒤로가기" />
      </a>
    </header>

    <div class="sign-up-title">
      <h3>회원가입</h3>
    </div>

    <form class="sign-up-form">
      <!--        이름-->
      <label>
        <p class="sign-up-form__input-info">이름</p>
        <input
          class="sign-up-form__text-input"
          type="text"
          placeholder="홍길동"
          v-model="user.userName"
        />
      </label>

      <!--        이메일-->
      <label>
        <p class="sign-up-form__input-info">이메일</p>
        <input
          class="sign-up-form__text-input"
          type="email"
          placeholder="example@gmail.com"
          v-model="user.userEmail"
        />
        <p class="sign-up-form__error-message">
          올바른 이메일 형식을 입력해주세요.
        </p>
      </label>

      <!--        비밀번호-->
      <label>
        <p class="sign-up-form__input-info">비밀번호</p>
        <input
          class="sign-up-form__text-input"
          type="password"
          v-model="user.userPassword"
          placeholder="대소문자, 숫자, 특수문자 포함 8~16자리"
          maxlength="16"
        />
        <p class="sign-up-form__error-message">
          대소문자, 숫자, 특수문자 포함 8~16자리
        </p>
      </label>

      <!--        전화번호-->
      <label>
        <p class="sign-up-form__input-info">전화번호</p>
        <input
          class="sign-up-form__text-input"
          type="text"
          placeholder="하이픈(-)을 제외하고 입력해주세요."
          v-model="user.userContact"
        />
        <p class="sign-up-form__error-message">
          올바른 전화번호 형식을 입력해주세요.
        </p>
      </label>
      <!--input 양식 에러발생 시 label 태그에 sign-up-form--error 클래스
      <label class="sign-up-form--error">
        <input
          class="sign-up-form__text-input"
          type="password"
          v-model="userPasswordCheck"
          placeholder="비밀번호 확인"
        />
        <p class="sign-up-form__error-message" v-show="checkPassword === false">
          비밀번호가 같지 않습니다.
        </p>
        <p class="sign-up-form__error-message" v-show="checkPassword === true">
          비밀번호가 같습니다.
        </p>
      </label>-->

      <!--        지역-->
      <label>
        <p class="sign-up-form__input-info">지역</p>
        <div class="dropdown-container">
          <select
            class="sign-up-form__dropdown"
            v-model="districtName"
            @change="selected"
          >
            <option v-for="district in districts" :key="district.value">
              {{ district.districtName }}
            </option>
          </select>
        </div>
      </label>

      <!--        이용동의 체크-->
      <div class="form__check">
        <ul>
          <li class="check-box-line">
            <p>아래 약관에 모두 동의합니다.</p>
            <input type="checkbox" id="all-check" class="input-checkbox" />
            <label for="all-check"></label>
          </li>
          <li>
            <a>[필수] 개인정보 수집 및 이용 동의</a>
            <input
              type="checkbox"
              id="privacy-check"
              class="input-checkbox"
              name="signUp"
            />
            <label for="privacy-check"></label>
          </li>
          <li>
            <a>[필수] 서비스 이용약관 동의</a>
            <input
              type="checkbox"
              id="service-check"
              class="input-checkbox"
              name="signUp"
            />
            <label for="service-check"></label>
          </li>
        </ul>
      </div>
      <button class="sign-up-form__button" @click.prevent="doSignup">
        가입완료
      </button>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Signup",
  data() {
    return {
      user: {
        userName: null,
        userEmail: null,
        userPassword: null,
        userContact: null,
        userAuth: "ROLE_USER",
      },
      userPasswordCheck: null,
      checkPassword: false,
      districts: [
        { value: "0", districtName: "서울특별시" },
        { value: "1", districtName: "부산광역시" },
        { value: "2", districtName: "대구광역시" },
        { value: "3", districtName: "인천광역시" },
        { value: "4", districtName: "광주광역시" },
        { value: "5", districtName: "대전광역시" },
        { value: "6", districtName: "울산광역시" },
        { value: "7", districtName: "세종특별자치시" },
        { value: "8", districtName: "경기도" },
        { value: "9", districtName: "강원도" },
        { value: "10", districtName: "충청북도" },
        { value: "11", districtName: "충청남도" },
        { value: "12", districtName: "전라북도" },
        { value: "13", districtName: "전라남도" },
        { value: "14", districtName: "경상북도" },
        { value: "15", districtName: "경상남도" },
        { value: "16", districtName: "제주특별자치도" },
      ],
    };
  },
  methods: {
    doSignup() {
      axios
        .post("/api/users/signup", {
          name: this.user.userName,
          email: this.user.userEmail,
          password: this.user.userPassword,
          district: this.districtName,
          userAuth: this.user.userAuth,
          contact: this.user.userContact
        })
        .then((response) => {
          if (response.status === 200) {
            alert("회원가입이 완료되었습니다.");
            this.$router.push({ name: "Login", component: "Login" });
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
    async checkPasswordMethod() {
      if (this.userPassword === this.userPasswordCheck) {
        this.checkPassword = true;
      }
    },
  },
};
</script>

<style>
@import "@/assets/scss/style.scss";
.sign-up-title {
  padding: 0 24px;
  height: 48px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.sign-up-title > h3 {
  font-size: 24px;
}
.sign-up-title > h3 > span {
  font-size: 16px;
}
.sign-up-title p {
  font-family: "Roboto", sans-serif;
  font-size: 16px;
  font-weight: bold;
}
.sign-up-form {
  margin-top: 24px;
  padding: 0 24px;
}
.sign-up-form > label {
  margin-top: 16px;
  display: block;
}
/*
이메일, 비밀번호 입력 input / button
*/
.sign-up-form__text-input[type="text"],
.sign-up-form__text-input[type="email"],
.sign-up-form__text-input[type="password"] {
  box-sizing: border-box;
  padding-left: 8px;
  width: 100%;
  height: 48px;
  cursor: text;
  background-color: #fafafa;
  -webkit-transition: all 0.2s ease-in-out;
  -o-transition: all 0.2s ease-in-out;
  transition: all 0.2s ease-in-out;
}
.sign-up-form__text-input[type="text"]:focus-visible,
.sign-up-form__text-input[type="email"]:focus-visible,
.sign-up-form__text-input[type="password"]:focus-visible {
  outline: 0;
  box-shadow: inset 0 -2px 0 #000000;
}
.sign-up-form__input-info {
  margin: 2px 0;
  font-size: 14px;
  color: #a9a9a9;
}
.sign-up-form__error-message {
  display: none;
}
.sign-up-form--error > .sign-up-form__error-message {
  margin-top: 4px;
  display: block;
  font-size: 14px;
  color: #da8282;
}
.sign-up-form--error > input {
  outline: 0;
  box-shadow: inset 0 -2px 0 #ff3030;
}
.sign-up-form__button {
  margin-top: 24px;
  width: 100%;
  height: 48px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 16px;
  color: white;
  background-color: black;
  -webkit-transition: all 0.2s ease-in-out;
  -o-transition: all 0.2s ease-in-out;
  transition: all 0.2s ease-in-out;
}
.sign-up-form__button:hover {
  background-color: #343434;
}
.sign-up-form__button:disabled {
  background-color: #c5c5c5;
}
/*
회원가입 지역 선택 dropdown
*/
.dropdown-container {
  width: 100%;
  display: flex;
  justify-content: space-between;
}
.sign-up-form__dropdown {
  box-sizing: border-box;
  padding-left: 8px;
  height: 48px;
  background-color: #fafafa;
}
.dropdown-container > .sign-up-form__dropdown:nth-child(2) {
  width: 100%;
}
.dropdown-container > .sign-up-form__dropdown:nth-child(1) {
  margin-right: 16px;
}
.sign-up-form__dropdown:focus-visible {
  outline: 0;
  box-shadow: inset 0 -2px 0 #000000;
}
.form__check {
  margin-top: 24px;
}
.form__check > ul {
  padding: 0;
}
.form__check > ul > li {
  padding: 8px 0;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.check-box-line {
  border-bottom: 1px solid #bfbfbf;
}
.log-in__check {
  margin: 16px 0;
  display: flex;
  align-items: center;
  justify-content: space-between;
  font-size: 14px;
}
.remember-email {
  display: flex;
  align-items: center;
}
.remember-email label {
  margin-right: 8px;
}
</style>
