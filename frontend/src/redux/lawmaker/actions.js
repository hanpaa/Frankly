import {
  FETCH_LAWMAKER_REQUEST,
  FETCH_LAWMAKER_SUCCESS,
  FETCH_LAWMAKER_FAILURE, } from "./types";

export const fetchLawmakerRequest = () => {
  return {
    type: FETCH_LAWMAKER_REQUEST
  }
}

export const fetchLawmakerSuccess = (list) => {
  return {
    type: FETCH_LAWMAKER_SUCCESS,
    payload: list
  }
}

export const fetchLawmakerFailure = (err) => {
  return {
    type: FETCH_LAWMAKER_FAILURE,
    payload: err
  }
}

export const fetchLawmaker = (id) => {
  return (dispatch) => {
    dispatch(fetchLawmakerRequest())
    fetch(`http://frankly.kro.kr:8081/api/infos/${id}`)
      .then(res => res.json())
      .then(list =>
        dispatch(fetchLawmakerSuccess(list)))
      .catch(err => fetchLawmakerFailure(err))
  }
}