package com.mint.assestment.enums;
public enum Success {
	
		KAFKA_PUBLISHED("Message successfully published to kafka");
	
		private String value;

		private Success(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
