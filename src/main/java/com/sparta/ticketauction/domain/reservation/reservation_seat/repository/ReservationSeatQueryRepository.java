package com.sparta.ticketauction.domain.reservation.reservation_seat.repository;

import java.util.List;

import com.sparta.ticketauction.domain.reservation.reservation_seat.entity.ReservationSeat;
import com.sparta.ticketauction.domain.seat.response.ReservedSeatResponse;

public interface ReservationSeatQueryRepository {

	/**
	 * 예약에 포함된 예약 좌석들의 목록을 조회한다.
	 * @param reservationId
	 * @return List<ReservationSeatId>
	 */
	List<ReservationSeat> findReservationSeatsByReservationId(Long reservationId);

	// 회차에 예약된 좌석들의 목록을 조회한다.
	List<ReservedSeatResponse> findReservedSeats(Long scheduleId);
}
