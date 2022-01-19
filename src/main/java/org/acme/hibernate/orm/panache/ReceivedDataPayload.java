package org.acme.hibernate.orm.panache;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

@Entity
@Table(name = "received_data_source")
public class ReceivedDataPayload extends PanacheEntity {

	@Column(name = "rd_id")
	public Long rdId;

	@Column(columnDefinition = "varchar", name = "source")
	public String payload;
}
