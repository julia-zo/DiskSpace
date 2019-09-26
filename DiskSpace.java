import java.util.Set;
import java.util.TreeSet;

public class DiskSpace {

    /**
    * Method to analyse if there is enough contiguous space
    * in a givem disk block to store a particular file.
    *
    * @param blockSize size of a given disk block
    * @param fileSize size of the file to be stored
    * @param occupiedSectors set listing which sectors of 
    * the block are unavailable
    * @return boolean if the file is writable in this block
    */
    public static boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors) {
        if (occupiedSectors.isEmpty()){
            //considering fileSize is never greater than blockSize
            //then, the file will always be able to be stored
            //when there are no occupied sectors
            return true;
        }
        
        //check how full the occupiedSectors set is
        //it has to be enough space to file the file
        //before we investigate if the space is contiguos or not
        if ( blockSize - occupiedSectors.size() < fileSize) {
            return false;
        }
        
        //sort occupied sectors to have a linear perspective
        //on which sector is occupied.
        Set<Integer> sortedSectors = new TreeSet<>(); 
        sortedSectors.addAll(occupiedSectors);
        
        //verify if the available space is contiguos
        //previousSector start at 0 meaning there is no previous
        //sector in the set
        int previousSector = 0;
        for (Integer sector : sortedSectors) {
            //calculate the space between one set the the previous
            // set -1, as the sectors are inclusive
            //e.g sector 6 - previous 4 - 1 = 1 free sector, sector 5
            if ( sector - previousSector - 1 >= fileSize) {
                return true;
            }
            previousSector = sector;
        }
        
        //verify if there is available space after the 
        //last occupied sector
        return (blockSize - previousSector >= fileSize);
    }
}

