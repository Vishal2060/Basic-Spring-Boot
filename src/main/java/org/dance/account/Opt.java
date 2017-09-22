package org.dance.account;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Opt implements Operation {

	PLUS(1){		
		@Override
		public int apply(int a, int b) {
			return a+b;
		}
	},
	MINUS(2) {
		@Override
		public int apply(int a, int b) {
			return a-b;
		}
	};
	
	private int idx;
}
