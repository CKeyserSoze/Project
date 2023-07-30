package com.cobanoglu.service;

import com.cobanoglu.dto.MergedTextDto;
import com.cobanoglu.model.MergedText;
import com.cobanoglu.repository.MergedTextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MergedTextService {

    private final MergedTextRepository mergedTextRepository;
    private final NextSequenceService nextSequenceService;

    public List<MergedText> getAll() {
        return mergedTextRepository.findAll();
    }

    public MergedText printMergedText(MergedTextDto mergedTextDto) {
        long startTime = System.currentTimeMillis();

        MergedText mergedText = new MergedText();
        mergedText.setText(birlestir(mergedTextDto.getText()));
        mergedText.setId(nextSequenceService.getNextSequence("customSequences"));

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        mergedText.setTime(duration);

        return mergedText;
    }

    public String saveMergedText(MergedText mergedText) {
        if (!mergedText.getText().trim().isEmpty()) {
            mergedTextRepository.save(mergedText);
            return "Birleştirilmiş metin kaydedildi!";
        } else {
            return "Input'ları kontrol ediniz!";
        }
    }

    public static String birlestir(List<String> cumleler) {
        Map<String, Integer> kelimeSayilari = new HashMap<>();
        for (String cumle : cumleler) {
            String[] kelimeler = cumle.toLowerCase().split(" ");
            for (String kelime : kelimeler) {
                kelimeSayilari.put(kelime, kelimeSayilari.getOrDefault(kelime, 0) + 1);
            }
        }

        StringBuilder birlesmisCumle = new StringBuilder();
        Set<String> birlestirilmisKelimeler = new HashSet<>();
        for (String cumle : cumleler) {
            String[] kelimeler = cumle.toLowerCase().split(" ");
            for (String kelime : kelimeler) {
                if (kelimeSayilari.get(kelime) > 1) {
                    if (birlestirilmisKelimeler.contains(kelime)) {
                        continue;
                    }
                    birlestirilmisKelimeler.add(kelime);
                }
                birlesmisCumle.append(kelime).append(" ");
            }
        }

        return birlesmisCumle.toString().trim();
    }
}
