import java.util.ArrayList;
import java.util.Scanner;

class Task {
    int id;
    String name;
    boolean isDone;

    Task(int id, String name) {
        this.id = id;
        this.name = name;
        this.isDone = false;
    }

    @Override
    public String toString() {
        return id + ". " + name + " [" + (isDone ? "Selesai" : "Belum") + "]";
    }
}

public class TodoListApp {
    static ArrayList<Task> tasks = new ArrayList<>();
    static int nextId = 1;
    static Scanner scanner = new Scanner(System.in);

    static void addTask() {
        System.out.print("Nama tugas: ");
        String name = scanner.nextLine();
        tasks.add(new Task(nextId++, name));
        System.out.println("Tugas ditambahkan.");
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Belum ada tugas.");
        } else {
            for (Task t : tasks) {
                System.out.println(t);
            }
        }
    }

    static void markDone() {
        System.out.print("Masukkan ID tugas yang selesai: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Task t : tasks) {
            if (t.id == id) {
                t.isDone = true;
                System.out.println("Tugas " + id + " ditandai selesai.");
                return;
            }
        }
        System.out.println("ID tidak ditemukan.");
    }

    static void deleteTask() {
        System.out.print("Masukkan ID tugas yang akan dihapus: ");
        int id = Integer.parseInt(scanner.nextLine());
        tasks.removeIf(t -> t.id == id);
        System.out.println("Tugas dihapus (jika ada).");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== APLIKASI TODO LIST ===");
            System.out.println("1. Tambah tugas");
            System.out.println("2. Lihat tugas");
            System.out.println("3. Tandai selesai");
            System.out.println("4. Hapus tugas");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            String pilih = scanner.nextLine();

            switch (pilih) {
                case "1": addTask(); break;
                case "2": viewTasks(); break;
                case "3": markDone(); break;
                case "4": deleteTask(); break;
                case "5": System.out.println("Sampai jumpa!"); return;
                default: System.out.println("Pilihan salah.");
            }
        }
    }
}
