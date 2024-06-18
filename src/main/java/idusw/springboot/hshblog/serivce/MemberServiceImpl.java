package idusw.springboot.hshblog.serivce;

import idusw.springboot.hshblog.entity.MemberEntity;
import idusw.springboot.hshblog.model.MemberDto;
import idusw.springboot.hshblog.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    final MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public int create(MemberDto memberDto) {
        int ret = 0;
        MemberEntity entity = dtoToEntity(memberDto);
        memberRepository.save(entity);
        ret = 1;
        return ret;
    }

    @Override
    public MemberDto readByIdx(Long idx) {
        if(!memberRepository.findByIdx(idx).isEmpty())
            return entityToDto(memberRepository.findByIdx(idx).get());
        else
            return null;
    }

    @Override
    public List<MemberDto> readAll() {
        List<MemberEntity> list = memberRepository.findAll();
        List<MemberDto> dtoList = new ArrayList<MemberDto>();
        for (MemberEntity memberEntity : list) {
            dtoList.add(entityToDto(memberEntity));
        }
        return dtoList;
    }

    @Override
    public int update(MemberDto memberDto) {
        MemberEntity entity = dtoToEntity(memberDto);
        memberRepository.save(entity); // save 메서드는 존재하는 데이터를 갱신하기 위해 사용
        return 1; // 성공적으로 업데이트 되었음을 의미하는 값을 반환
    }

    @Override
    public int delete(MemberDto memberDto) {
       return 0;
    }
    @Override
    public MemberDto loginById(MemberDto memberDto) {
        Optional<MemberEntity> memberEntityOptional = memberRepository.findByIdAndPw(memberDto.getId(), memberDto.getPw());
        return memberEntityOptional.map(this::entityToDto).orElse(null);
    }

}
