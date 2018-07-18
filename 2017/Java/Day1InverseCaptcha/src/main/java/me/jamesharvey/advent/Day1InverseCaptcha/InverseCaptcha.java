package me.jamesharvey.advent.Day1InverseCaptcha;

class InverseCaptcha {

	private String input;
	private Integer result;
	
	protected void calculateCodeNextCharacter() {
    	result = 0;
		
		for(int i = 0; i < input.length(); i++) {
			if(i == input.length()-1) {
				if(compareDigits(i, 0)) {
					sumDigits(0);
				}
			} else {
				if(compareDigits(i, i+1)) {
					sumDigits(i+1);
				}
			}
		}
    }
	
	protected void calculateCodeOppositeHalfCharacter() {
    	result = 0;
    	int length = input.length();
		int midPoint = length/2;
		for(int i = 0; i < length; i++) {
			if(i < midPoint) {
				if(compareDigits(i, i+midPoint)) {
					sumDigits(i);
				}
			} else {
				if(compareDigits(i, i - midPoint)) {
					sumDigits(i);
				}
			}
		}

    }

	private boolean compareDigits(int firstIndex, int secondIndex) {
		return input.charAt(firstIndex) == input.charAt(secondIndex);
	}
	
	private void sumDigits(int index) {
		result += Integer.parseInt(String.valueOf(input.charAt(index)));
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public Integer getResult() {
		return result;
	}
}
