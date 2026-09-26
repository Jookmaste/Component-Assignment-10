package se331.lab.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;
import se331.lab.entity.Participant;
import se331.lab.repository.EventRepository;
import se331.lab.repository.OrganizerRepository;
import se331.lab.repository.ParticipantRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;

    @Override
    @Transactional
    public void onApplicationEvent (ApplicationReadyEvent applicationReadyEvent) {
        Participant part1, part2, part3, part4, part5;
        part1 = participantRepository.save(Participant.builder()
                .name("participant1")
                .telNo("0123456789")
                .build());
        part2 = participantRepository.save(Participant.builder()
                .name("participant2")
                .telNo("0123456789")
                .build());
        part3 = participantRepository.save(Participant.builder()
                .name("participant3")
                .telNo("0123456789")
                .build());
        part4 = participantRepository.save(Participant.builder()
                .name("participant4")
                .telNo("0123456789")
                .build());
        part5 = participantRepository.save(Participant.builder()
                .name("participant5")
                .telNo("0123456789")
                .build());
        List<Participant> participants = new ArrayList<>();
        participants.add(part1);
        participants.add(part2);
        participants.add(part3);
        participants.add(part4);
        participants.add(part5);

        Organizer org1, org2, org3;
        org1 = organizerRepository.save(Organizer.builder()
                .name("CAMT")
                .build());
        org2 = organizerRepository.save(Organizer.builder()
                .name("CMU")
                .build());
        org3 = organizerRepository.save(Organizer.builder()
                .name("ChiangMai")
                .build());
        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petsAllowed(false)
                .participants(participants)
                .build());
        tempEvent.setOrganizer(org1);
        part1.getEventHistories().add(tempEvent);
        part2.getEventHistories().add(tempEvent);
        part4.getEventHistories().add(tempEvent);
        org1.getOwnEvents().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petsAllowed(false)
                .participants(participants)
                .build());
        tempEvent.setOrganizer(org1);
        part1.getEventHistories().add(tempEvent);
        part2.getEventHistories().add(tempEvent);
        part3.getEventHistories().add(tempEvent);
        part4.getEventHistories().add(tempEvent);
        org1.getOwnEvents().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00am-10.00 pm.")
                .petsAllowed(false)
                .participants(participants)
                .build());
        tempEvent.setOrganizer(org2);
        part1.getEventHistories().add(tempEvent);
        part2.getEventHistories().add(tempEvent);
        part3.getEventHistories().add(tempEvent);
        org2.getOwnEvents().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am-6.00 pm.")
                .petsAllowed(true)
                .participants(participants)
                .build());
        tempEvent.setOrganizer(org3);
        part1.getEventHistories().add(tempEvent);
        part2.getEventHistories().add(tempEvent);
        part3.getEventHistories().add(tempEvent);
        part4.getEventHistories().add(tempEvent);
        part5.getEventHistories().add(tempEvent);
        org3.getOwnEvents().add(tempEvent);
    }
}
