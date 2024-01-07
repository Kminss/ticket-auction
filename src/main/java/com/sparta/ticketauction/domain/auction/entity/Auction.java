package com.sparta.ticketauction.domain.auction.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.Comment;

import com.sparta.ticketauction.domain.auction.request.AuctionCreateRequest;
import com.sparta.ticketauction.global.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "auction")
public class Auction extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Comment("시작가")
	@Column(name = "start_price", nullable = false)
	private long startPrice;

	@Comment("입찰가")
	@Column(name = "start_price", nullable = false)
	private long bidPrice;
	@Comment("시작일시")
	@Column(name = "start_date", nullable = false)
	private LocalDateTime startDateTime;

	@Comment("마감일시")
	@Column(name = "end_date", nullable = false)
	private LocalDateTime endDateTime;

	@Comment("종료여부 T - 종료 / F - 진행 중")
	@Column(name = "is_ended")
	private boolean isEnded;

	private Auction(long startPrice, LocalDateTime startDateTime, LocalDateTime endDateTime) {
		this.startPrice = startPrice;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
	}

	public static Auction of(AuctionCreateRequest request) {
		return new Auction(
			request.getStartPrice(),
			request.getStartDateTime(),
			request.getEndDateTime()
		);
	}
}
