package abc.ahnen;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AhnenTestJSONSchema {


    @Test
    public void erzeugeAhneUeberBuilder() {
        final Ahne ahne = Ahne.builder()
                .withGeburtsdatum(LocalDate.of(1968, 12, 25))
                .build();
        assertEquals("1968-12-25", ahne.getGeburtsdatum().toString());

    }

    @Test
    public void erzeugeAhneAusJSONFile() {
        final Ahne thomas = Ahne.load().fromJsonFile(
                Paths.get("src/main/resources","/abc/ahnen/ThomasSchubert.json").toFile()
        );
        assertEquals("1968-12-24", thomas.getGeburtsdatum().toString());
        assertNull( thomas.getName());
        assertNull( thomas.getVorname());

        final Ahne liona = Ahne.load().fromJsonFile(
                Paths.get("src/main/resources","/abc/ahnen/LionaSidorova.json").toFile()
        );
        assertEquals("1968-01-01", liona.getGeburtsdatum().toString());
        assertEquals("Sidorova", liona.getName());
        assertEquals("Liona", liona.getVorname());

    }
}
