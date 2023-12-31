

# CHAPTER 1 - INTRODUCTION

* Introduction to the course
* History of the Internet
* Concept of Computer Networks
* Architecture
* Topology
* Protocol
* Circuit switching vs. packet switching.
	* Pros and cons

# CHAPTER 2 - CONCEPTS OF COMPUTERS COMMUNICATIONS

+ Layering architecture on the Internet (OSI - TCP/IP model)
+ Identification on the Internet (MAC, IP, ports)
+ ARP (Address resolution protocol): use to convert IP address -> MAC address. 


# CHAPTER 3 - DATA LINK LAYER

CABLES: 

	- UTP: cheap, widely used, have weak resistance to noise, short transmission distance (100m - before the need of amplification/repeat)

	- Coaxial: used in TV signal transmission or telephone networks; 
	  is being replaced by fiber-optics cable, can be used to link computers of short distance, transmission distance varied (RG11: ~1100m , RG58: ~185m)

	- Fiber optics: used for long-range transmission; communication in metropolitan networks; connecting routers of ISP; or in backbone part of a LAN;
	  *HAVE HUGE ADVANTAGES over other type of cables: large data rate, small and light, better isolation from electromagnetic environment, much further range of transmission before needing amp/repeat.
	  *THE ONLY DISADVANTAGE? : It's FORKIN EXPENSIVE $$$

WIRELESS MEDIA:

	- Data transmission on different frequency band of electromagnetic waves
	- Broadcast, half-duplex: only send or receive at a time
	- Easily affected by environment: reflections, noise/inteference or scattering

DATA ENCODING: (how data/a bit is encoded over a medium)

	- Forms of encoding : digital/analog <----> digital/analog - total of 4 types
	- Line encoding consideration: 
	    + Clock recovery on receiver side: If the clock recovery is not ideal, then the signal to be decoded will not be sampled at
	      the optimal times. This will increase the probability of error in received data.
	    + DC-component: Encoding should avoid DC-component by having signal mean altitude to be around 0.

NRZ (Non return to zero):

	NRZ-L: a bit 0/1 is determined by signal level

	NRZ-I: a bit 0/1 is determined by signal level change

	*NRZ properties: simple, but does not contain element supporting clock sync -> only use in encoding on magnetic storage

Bipolar AMI:

	- Properties: use more than 2 signal level for the 1-bit.

	- Variations: Alternate mark inversion | Pseudoternary
		+ Alternate mark inversion: 0 = no signal ; 1 = presence of signal, 
		  with 2 consecutive 1s having different signal level.
		+ Pseudoternary: The opposite of alternate mark inversion

	* Remark: DC component = 0
		  Good sync when there's many bit in the non-zero level
		  Not optimal for using in transmission line because the receiver needs to 
		  distinguish 3 different levels of signal.

Biphase / Manchester:
	
	- Properties: Always change signal level in the middle of bit time.

	- Variations: Manchester | Differential Manchester
		+ Manchester: signal level change at middle of bit time determine the bit
		+ Diff Manchester: signal level change at a bit interval determine the bit value.
	 	      			
	
Encoding digital data to analog signal:

	- Amplitude shift keying: 
		Use 2 different amplitude for 0s/1s, one level is typically 0.
		Easily impact by noise.
		Hard to sync signals.
		Used in optical cable.

	- On-off keying: During a bit interval : 0 = no light; 1 = light and vice-versa.

	- Frequency shift keying: Use 2 different frequencies to encode 0/1. 
				  Low error rate.
				  Use to transfer data in telephone lines.
				

	- Phase shift keying: Use different phase to encode data.
			      Can be used to encode multiple bits at once.
			      Can be combined with ASK.

Encoding analog data to digital signal:
	
	*Shannon sampling theorem: The sampling rate is be equal to or greater than twice the highest frequency of the signal, 
				   then the original signal can be considered intact.
	Example: maximum freq of human voice is 4300hz -> minimum sampling freq should be 8600hz.

	- Pulse Code Modulation.

	- Delta modulation: Use a stair case function; if the approx falls below the signal -> 1 otherwise 0; the approximation level then is increase if it's a 1/ decrease otherwise.
			    The staircase function has a delta (step-size) and a frequency. 
			    Slow-change signal/ small delta: quantization error / granular noise. 
                            Fast-change signal/ large delta: Slope Over load distortion.

Analog data to analog signals:
	- Combine the data signal with a carrier into a single signal.
	- 3 different methods:  Amplitude modulation.
				Frequency modulation.
				Phase modulation.


▒█▀▀█ █░░█ █▀▀█ █▀▀█ ▀▀█▀▀ █▀▀ █▀▀█ 　 ░█▀█░ ▄ 　 ▒█▀▀▄ █▀▀█ ▀▀█▀▀ █▀▀█ █░░ ░▀░ █▀▀▄ █░█ 　 █░░ █▀▀█ █░░█ █▀▀ █▀▀█ 
▒█░░░ █▀▀█ █▄▄█ █░░█ ░░█░░ █▀▀ █▄▄▀ 　 █▄▄█▄ ░ 　 ▒█░▒█ █▄▄█ ░░█░░ █▄▄█ █░░ ▀█▀ █░░█ █▀▄ 　 █░░ █▄▄█ █▄▄█ █▀▀ █▄▄▀ 
▒█▄▄█ ▀░░▀ ▀░░▀ █▀▀▀ ░░▀░░ ▀▀▀ ▀░▀▀ 　 ░░░█░ ▀ 　 ▒█▄▄▀ ▀░░▀ ░░▀░░ ▀░░▀ ▀▀▀ ▀▀▀ ▀░░▀ ▀░▀ 　 ▀▀▀ ▀░░▀ ▄▄▄█ ▀▀▀ ▀░▀▀


LAYER PACKET: frame

LAYER DEVICES: hub, switch

Function: Framing, addressing, flow/error control, media access control

- The link layer is implemented inside a Network Interface Card (NIC)

Identifier: MAC address - 48-bit address, organized by IEEE (Insitute of Electrical and Electronics Engineers). MAC address is unchanged when changing networks(?)


Error detection:
	- Objective: ensure the data is transmitted correctly even under unreliable conditions
Parity bit:	
	
	- Single bit parity: a bit at the end of a row, set to either 0 or 1 to ensure that the number of 1s is even.

	- Two-dimensional parity: a bit at the end of rows and collumns, set to either 0 or 1 to ensure that the number of 1s in that row/collumn is even.  

Checksums: 

CRC:

Stop-and-wait ARQ(Automatically repeated requests):
 	- Stop and wait: Each packet sent would be reply with an ACK packet, only proceed to send the next packet if the previous packet is ACKed, otherwise continue
			 to resend.
			 Possible errors: Lost ACK -> Solution: Sender automatically resend after timeout (timeout >=1 RTT); Reciever automatically discard packet if it's a duplicate.	  

Flow control:
	- Objective: Make sure the sender doesn't overload the reciever, because when the reciever buffer frame is full, all arriving frame after that point would be dropped.

	- Stop-and-wait: like the above stop-and-wait ARQ, just without the ARQ part.

	- Sliding window: Sender send more than one frame at a time; transmitted frame without ACK will be stored in buffer.
	
	- Piggy backing: A and B transmit data from both sides. When B needs to send ACK while still need to send data, B can attach the ACK to the data frame and send it altogether. 
			 Otherwise, send the ACK seperately. After an ACK is send, if B send another data frame, the ACK previously send would still be attached to the frame (avoiding ACK lost).

Excercise: page 45-51

Media access control (MAC):

		

	


			       



