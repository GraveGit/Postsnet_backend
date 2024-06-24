package org.postsnet.service;

import io.minio.DownloadObjectArgs;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.UploadObjectArgs;
import lombok.RequiredArgsConstructor;
import org.postsnet.dto.CommentDTO;
import org.postsnet.dto.MediaDTO;
import org.postsnet.entity.Comment;
import org.postsnet.entity.Media;
import org.postsnet.repository.CommunityRepository;
import org.postsnet.repository.MediaRepository;
import org.postsnet.repository.PostRepository;
import org.postsnet.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MediaService {

    private final MediaRepository mediaRepository;

    MinioClient minioClient = MinioClient.builder()
            .endpoint("http://127.0.0.1:9000/")
            .credentials("eyUxngoFu3e3VxGYOwFy", "GyXKCCw4z57nLeWsI16dleFgu9Tz6pvWEm4fP4EE")
            .build();

    private final UserRepository userRepository;
    private final CommunityRepository communityRepository;
    private final PostRepository postRepository;

    public Media create(MediaDTO dto) throws Exception {
        Media media = Media.builder()
                .content(dto.getContent())
                .user(userRepository.findByUserId(dto.getUser()))
                .community(communityRepository.findByCommunityId(dto.getPost()))
                .post(postRepository.findByPostId(dto.getPost()))
                .build();

        uploader(minioClient, "pictures", "image.png", "D:/images/image.png", "image/png");

        return mediaRepository.save(media);
    }

    public Media readById(Long id) throws Exception {

        downloader(minioClient, "pictures", "image.png", "D:/imagefromminio.png");

        return mediaRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cannot find media by id" + id));

    }

    private static void uploader(MinioClient minioClient, String bucketName, String objectName, String fileName, String contentType) throws Exception {

        UploadObjectArgs uArgs = UploadObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .filename(fileName)
                .contentType(contentType)
                .build();
        ObjectWriteResponse resp = minioClient.uploadObject(uArgs);
    }

    private static void downloader(MinioClient minioClient, String bucketName, String objectName, String fileName) throws Exception {

        DownloadObjectArgs dArgs = DownloadObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .filename(fileName)
                .build();

        minioClient.downloadObject(dArgs);
    }
}
