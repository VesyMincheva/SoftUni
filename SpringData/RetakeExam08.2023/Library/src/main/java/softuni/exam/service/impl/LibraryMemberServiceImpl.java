package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BookImportDto;
import softuni.exam.models.dto.LibraryMemberImportDto;
import softuni.exam.models.entity.Book;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.LibraryMemberService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryMemberServiceImpl implements LibraryMemberService {

    private final LibraryMemberRepository libraryMemberRepository;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public LibraryMemberServiceImpl(LibraryMemberRepository libraryMemberRepository, ValidationUtils validationUtils, ModelMapper modelMapper, Gson gson) {
        this.libraryMemberRepository = libraryMemberRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.libraryMemberRepository.count() > 0;
    }

    @Override
    public String readLibraryMembersFileContent() throws IOException {
        return Files.readString(Path.of("src/main/resources/files/json/library-members.json"));
    }

    @Override
    public String importLibraryMembers() throws IOException {
        final StringBuilder libraryMembersResult = new StringBuilder();

        final List<LibraryMemberImportDto> members =
                Arrays.stream(gson.fromJson(readLibraryMembersFileContent(), LibraryMemberImportDto[].class))
                        .collect(Collectors.toList());

        for (LibraryMemberImportDto member : members) {
            libraryMembersResult.append(System.lineSeparator());

            if (this.libraryMemberRepository.findFirstByPhoneNumber(member.getPhoneNumber()).isPresent() ||
                    !this.validationUtils.isValid(member)) {
                libraryMembersResult.append(String.format("Invalid library member"));
                continue;
            }

            LibraryMember memberToSave = this.modelMapper.map(member, LibraryMember.class);
            memberToSave.setFirsName(member.getFirstName());
            memberToSave.setLastName(member.getLastName());

            this.libraryMemberRepository.save(memberToSave);

            libraryMembersResult.append(String.format("Successfully imported library member %s - %s",
                    member.getFirstName(),
                    member.getLastName()));
        }

        return libraryMembersResult.toString().trim();
    }
}
